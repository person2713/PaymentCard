package com.team.mvc.database.repositories;

import com.team.mvc.database.mergedEntities.BalanceHistEvents;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BalanceHistEventsRepository extends AbstractRepository<BalanceHistEvents> {

    public BalanceHistEventsRepository() {
        super(BalanceHistEvents.class);
    }

    public List<BalanceHistEvents> getBalanceHistEventsByCardId(Long cardId) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createSQLQuery(
                    "SELECT  CASE  WHEN EV.EVENT_ID IS NOT NULL THEN 'Проезд'" +
                            "              ELSE 'Пополнение баланса' END AS transactionType," +
                            "        BH.CHANGES AS balance," +
                            "        BH.DATE_EVENT AS dateEvent," +
                            "        last_routes.ROUTE_ID AS routeId," +
                            "        last_routes.ROUTE_NUMBER AS routeNumber," +
                            "        last_routes.BUS_ID AS busId," +
                            "        BH.CARD_ID AS cardId," +
                            "        EV.LATITUDE AS latitude," +
                            "        EV.LONGITUDE AS longitude," +
                            "        EV.EVENT_ID AS eventId" +
                            "  FROM  BALANCE_HIST BH" +
                            "    LEFT OUTER JOIN EVENTS EV" +
                            "      ON  BH.CARD_ID=:cardId AND" +
                            "          EV.CARD_ID=:cardId AND" +
                            "          cast(BH.DATE_EVENT AS TIMESTAMP(0))=cast(EV.PAYMENT_TIME AS TIMESTAMP(0))" +
                            "      LEFT OUTER JOIN (" +
                            "        SELECT  ro.ROUTE_ID," +
                            "                ro.ROUTE_NUMBER," +
                            "                last_car_assign.BUS_ID AS BUS_ID" +
                            "          FROM ROUTES ro" +
                            "            INNER JOIN(" +
                            "              SELECT  car_as.ROUTE_ID," +
                            "                      car_as.BUS_ID" +
                            "                FROM  (" +
                            "                      SELECT  ca.ROUTE_ID," +
                            "                              ca.BUS_ID," +
                            "                              ca.DATE_ASSIGN,max(ca.DATE_ASSIGN) OVER (PARTITION BY ca.BUS_ID) AS last_date" +
                            "                        FROM  CAR_ASSIGN ca" +
                            "                      ) car_as" +
                            "                WHERE car_as.DATE_ASSIGN=car_as.last_date" +
                            "            ) last_car_assign" +
                            "              ON last_car_assign.ROUTE_ID=ro.ROUTE_ID" +
                            "        ) last_routes" +
                            "          ON last_routes.BUS_ID=EV.BUS_ID" +
                            "  WHERE BH.CARD_ID=:cardId" +
                            "  ORDER BY BH.DATE_EVENT"
            )
                    .addScalar("transactionType")
                    .addScalar("balance", BigDecimalType.INSTANCE)
                    .addScalar("dateEvent", TimestampType.INSTANCE)
                    .addScalar("routeId",LongType.INSTANCE)
                    .addScalar("routeNumber",StringType.INSTANCE)
                    .addScalar("busId",LongType.INSTANCE)
                    .addScalar("cardId",LongType.INSTANCE)
                    .addScalar("latitude",DoubleType.INSTANCE)
                    .addScalar("longitude",DoubleType.INSTANCE)
                    .addScalar("eventId",LongType.INSTANCE)
                    .setResultTransformer(new AliasToBeanResultTransformer(BalanceHistEvents.class))
//                    .setResultTransformer(Transformers.TO_LIST)
                    .setParameter("cardId", cardId);
            List<BalanceHistEvents> list = query.list();
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }
}