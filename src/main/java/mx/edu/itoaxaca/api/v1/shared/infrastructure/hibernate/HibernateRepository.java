package mx.edu.itoaxaca.api.v1.shared.infrastructure.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.criteria.CriteriaQuery;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;

public abstract class HibernateRepository<Entity> {

    protected final SessionFactory sessionFactory;
    protected final Class<Entity> aggregateClass;

    public HibernateRepository(
        SessionFactory sessionFactory,
        Class<Entity> aggregateClass
    ) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(Entity entity) {
        sessionFactory.getCurrentSession().merge(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected List<Entity> byCriteria(Criteria criteria) {
        CriteriaQuery<Entity> hibernateCriteria = new HibernateCriteriaConverter<Entity>().convert(criteria);

        return sessionFactory.getCurrentSession().createQuery(hibernateCriteria).getResultList();
    }
}
