package Model;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Author: Denis Lima
 */

public class GatewayDAO extends DAO {

    protected static GatewayDAO instance;

    public GatewayDAO() {
        super();
    }

    public static GatewayDAO getInstance() {
        if (instance == null) {
            instance = new GatewayDAO();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public List<Gateway> findAll() {
        return entityManager.createQuery("FROM " + Gateway.class.getName()).getResultList();
    }

}
