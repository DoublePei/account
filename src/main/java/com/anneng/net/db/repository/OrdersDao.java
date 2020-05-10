package com.anneng.net.db.repository;

import com.anneng.net.model.bean.Orders;
import com.anneng.net.model.bo.AggBo;
import com.anneng.net.model.vo.AggParams;
import com.anneng.net.model.vo.OrdersParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@Component
@Slf4j
public class OrdersDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Orders> getOrdersList(OrdersParams params) {
        String querySql = buildQuerySql(params);
        log.info(querySql);
        String limitPage = querySql + " limit " + (params.getPage()-1) + "," + params.getSize();
        List<Orders> orders = namedParameterJdbcTemplate.getJdbcTemplate()
                .query(limitPage, new BeanPropertyRowMapper<>(Orders.class));
        return orders;
    }

    public List<Orders> getOrdersListWithOutLimit(OrdersParams params) {
        String querySql = buildQuerySql(params);
        List<Orders> orders = namedParameterJdbcTemplate.getJdbcTemplate()
                .query(querySql, new BeanPropertyRowMapper<>(Orders.class));
        return orders;
    }

    public Long getOrdersCount(OrdersParams params) {
        String querySql = buildQuerySql(params);
        String count = "select count(1) from (" + querySql + ") a";
        Long nums = namedParameterJdbcTemplate.getJdbcTemplate()
                .queryForObject(count, Long.class);
        return nums;
    }

    public List<AggBo> getAggList(AggParams params) {
        String querySql = getAggsListSql(params);
        String limitPage = querySql + " limit " + (params.getPage()-1) + "," + params.getSize();
        log.info("getAggPage sql is {}", limitPage);
        List<AggBo> orders = namedParameterJdbcTemplate.getJdbcTemplate()
                .query(limitPage, new BeanPropertyRowMapper<>(AggBo.class));
        return orders;
    }

    public Long getAggCount(AggParams params) {
        String querySql = getAggsListSql(params);
        String count = "select count(1) from (" + querySql + ") a";
        log.info("getAggPage count sql is {}", count);
        Long nums = namedParameterJdbcTemplate.getJdbcTemplate()
                .queryForObject(count, Long.class);
        return nums;
    }


    private String buildQuerySql(OrdersParams params) {

        StringBuffer sb = new StringBuffer();
        sb.append("select * from orders where 1 = 1 ");
        appendSql(sb, params.getStartTime(), params.getEndTime(), params.getCompany());
        String dest = params.getDest();
        if (!isEmpty(dest)) {
            sb.append(" and dest = '")
                    .append(dest)
                    .append("' ");
        }
        String payType = params.getPayType();
        if (!isEmpty(payType)) {
            sb.append(" and pay_type = '")
                    .append(payType)
                    .append("' ");
        }
        appendSorted(sb, params.getSortProperties(), params.getSortDirection());
        return sb.toString();
    }

    private String getAggsListSql(AggParams params) {
        StringBuffer sb = new StringBuffer();
        sb.append("select sum(goods_num) as num " +
                ",sum(total_price) as price " +
                ",sum(cost) as cost " +
                ",sum(profit) as profit " +
                ",mail_date as date " +
                ",customer_name as name " +
                "from orders where 1 = 1 ");
        appendSqlByMailDate(sb, params.getStartTime(), params.getEndTime(), params.getCompany());
        sb.append(" group by customer_name,mail_date ");
        appendSorted(sb, params.getSortProperties(), params.getSortDirection());
        return sb.toString();
    }

    private void appendSorted(StringBuffer sb, String sortProperties2, String sortDirection) {
        String sortProperties = sortProperties2;
        String direction = sortDirection;
        if (!isEmpty(sortProperties) && !isEmpty(direction)) {
            sb.append(" order by ")
                    .append(sortProperties)
                    .append(" ")
                    .append(direction);
        } else {
            sb.append(" order by mail_date desc ");
        }
    }

    private void appendSql(StringBuffer sb, String startTime2, String endTime2, String company2) {
        String startTime = startTime2;
        String endTime = endTime2;
        if (!isEmpty(startTime) && !isEmpty(endTime)) {
            sb.append(" and mail_date >= '")
                    .append(startTime.split(" ")[0])
                    .append("' ")
                    .append(" and mail_date <= '")
                    .append(endTime.split(" ")[0])
                    .append("' ");
        }
        String company = company2;
        if (!isEmpty(company)) {
            sb.append(" and customer_name = '")
                    .append(company)
                    .append("' ");
        }
    }

    private void appendSqlByMailDate(StringBuffer sb, String startTime2, String endTime2, String company2) {
        String startTime = startTime2;
        String endTime = endTime2;
        if (!isEmpty(startTime) && !isEmpty(endTime)) {
            sb.append(" and mail_date >= '")
                    .append(startTime.split(" ")[0])
                    .append("' ")
                    .append(" and mail_date <= '")
                    .append(endTime.split(" ")[0])
                    .append("' ");
        }
        String company = company2;
        if (!isEmpty(company)) {
            sb.append(" and customer_name = '")
                    .append(company)
                    .append("' ");
        }
    }
}
