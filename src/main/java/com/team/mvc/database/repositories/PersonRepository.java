package com.team.mvc.database.repositories;


import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class PersonRepository extends AbstractRepository<Persons> {
    public PersonRepository() {
        super(Persons.class);
    }

    public Persons findBySSO(String nickname) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("NICKNAME", nickname));
        return (Persons) crit.uniqueResult();
    }
}