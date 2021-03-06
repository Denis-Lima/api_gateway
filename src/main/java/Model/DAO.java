package Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: Denis Lima
 */

public abstract class DAO {
    protected EntityManager entityManager;

    protected DAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("api_gateway");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }
}
