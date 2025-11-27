package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.ArrayList;

public class DuenioJpaController implements Serializable {

    public DuenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public DuenioJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Duenio duenio) {
        if (duenio.getListaMascotas() == null) {
            duenio.setListaMascotas(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            List<Mascota> attachedLista = new ArrayList<>();
            for (Mascota m : duenio.getListaMascotas()) {
                if (m != null && m.getNum_cliente() != 0) {
                    Mascota ref = em.getReference(Mascota.class, m.getNum_cliente());
                    attachedLista.add(ref);
                } else if (m != null) {
                    // mascota sin id, persistirla después de establecer dueño
                    attachedLista.add(m);
                }
            }
            duenio.setListaMascotas(attachedLista);

            em.persist(duenio);

            // actualizar cada mascota para que apunte al dueño
            for (Mascota m : duenio.getListaMascotas()) {
                if (m.getNum_cliente() == 0) {
                    // nueva mascota (sin id): asignar dueño y persistir
                    m.setUnDuenio(duenio);
                    em.persist(m);
                } else {
                    Duenio old = m.getUnDuenio();
                    m.setUnDuenio(duenio);
                    em.merge(m);
                    if (old != null && old.getId_duenio() != duenio.getId_duenio()) {
                        List<Mascota> oldList = old.getListaMascotas();
                        if (oldList != null) {
                            oldList.remove(m);
                            em.merge(old);
                        }
                    }
                }
            }

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Duenio duenio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Duenio persistentDuenio = em.find(Duenio.class, duenio.getId_duenio());
            if (persistentDuenio == null) {
                throw new NonexistentEntityException(
                        "The duenio with id " + duenio.getId_duenio() + " no longer exists.");
            }

            List<Mascota> listaOld = persistentDuenio.getListaMascotas() != null ? persistentDuenio.getListaMascotas()
                    : new ArrayList<>();
            List<Mascota> listaNew = duenio.getListaMascotas() != null ? duenio.getListaMascotas() : new ArrayList<>();

            List<Mascota> attachedNew = new ArrayList<>();
            for (Mascota m : listaNew) {
                if (m != null && m.getNum_cliente() != 0) {
                    Mascota ref = em.getReference(Mascota.class, m.getNum_cliente());
                    attachedNew.add(ref);
                } else if (m != null) {
                    attachedNew.add(m);
                }
            }
            duenio.setListaMascotas(attachedNew);

            duenio = em.merge(duenio);

            // Mascotas removidas: desvincular
            for (Mascota mOld : listaOld) {
                boolean found = false;
                for (Mascota mNew : attachedNew) {
                    if (mOld.getNum_cliente() != 0 && mNew.getNum_cliente() != 0
                            && mOld.getNum_cliente() == mNew.getNum_cliente()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    mOld.setUnDuenio(null);
                    em.merge(mOld);
                }
            }

            // Mascotas añadidas: vincular y actualizar viejo dueño si aplica
            for (Mascota mNew : attachedNew) {
                boolean wasOld = false;
                for (Mascota mOld : listaOld) {
                    if (mOld.getNum_cliente() != 0 && mNew.getNum_cliente() != 0
                            && mOld.getNum_cliente() == mNew.getNum_cliente()) {
                        wasOld = true;
                        break;
                    }
                }
                if (!wasOld) {
                    if (mNew.getNum_cliente() == 0) {
                        // nueva mascota: asignar dueño y persistir
                        mNew.setUnDuenio(duenio);
                        em.persist(mNew);
                    } else {
                        Duenio old = mNew.getUnDuenio();
                        mNew.setUnDuenio(duenio);
                        em.merge(mNew);
                        if (old != null && old.getId_duenio() != duenio.getId_duenio()) {
                            List<Mascota> oldList = old.getListaMascotas();
                            if (oldList != null) {
                                oldList.remove(mNew);
                                em.merge(old);
                            }
                        }
                    }
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = duenio.getId_duenio();
                if (findDuenio(id) == null) {
                    throw new NonexistentEntityException("The duenio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                duenio.getId_duenio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The duenio with id " + id + " no longer exists.", enfe);
            }

            if (duenio.getListaMascotas() != null) {
                for (Mascota m : new ArrayList<>(duenio.getListaMascotas())) {
                    m.setUnDuenio(null);
                    em.merge(m);
                }
            }
            em.remove(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Duenio> findDuenioEntities() {
        return findDuenioEntities(true, -1, -1);
    }

    public List<Duenio> findDuenioEntities(int maxResults, int firstResult) {
        return findDuenioEntities(false, maxResults, firstResult);
    }

    private List<Duenio> findDuenioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Duenio.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }

    public int getDuenioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Duenio> rt = cq.from(Duenio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    // Buscar dueños por nombre exacto
    public List<Duenio> buscarDuenioPorNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT d FROM Duenio d WHERE d.nombre = :nombre");
            q.setParameter("nombre", nombre);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Buscar dueños por nombre y celular (más preciso para evitar duplicados)
    // Búsqueda robusta que ignora espacios y diferencias de capitalización
    public List<Duenio> buscarDuenioPorNombreYCelular(String nombre, String celular) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT d FROM Duenio d WHERE " +
                    "TRIM(UPPER(d.nombre)) = TRIM(UPPER(:nombre)) AND " +
                    "TRIM(d.celDuenio) = TRIM(:celular)");
            q.setParameter("nombre", nombre);
            q.setParameter("celular", celular);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Buscar dueños que contengan el nombre (para autocompletado)
    public List<Duenio> buscarDueniosParaAutocompletar(String nombreParcial) {
        EntityManager em = getEntityManager();
        try {
            Query q = em
                    .createQuery("SELECT d FROM Duenio d WHERE LOWER(d.nombre) LIKE LOWER(:nombre) ORDER BY d.nombre");
            q.setParameter("nombre", "%" + nombreParcial + "%");
            q.setMaxResults(10); // Limitar resultados para autocompletado
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
