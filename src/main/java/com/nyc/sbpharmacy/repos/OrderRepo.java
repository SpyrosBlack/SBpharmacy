package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.Order;
import com.nyc.sbpharmacy.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    public List<Order> findByPharmacy(Pharmacy pharmacy);

//    select sum(p.quantity*m.medicineprice)
//    from pharmaorderitem p, medicine m
//    where p.medicineid =m.medicineid
//    and orderid in (
//            select orderid
//from pharmaorder p
//        where p.pharmacyid ='1')
//@Query(name="select sum(p.quantity*m.medicineprice)\n" +
//        "from OrderItem p\n" +
//        "join p.medicine m \n" +
//        "where p.order in (\n" +
//        "select o\n" +
//        "from Order o\n" +
//        "where o.pharmacy =?1)")

    @Query(value = """
            select sum(p.quantity*m.medicineprice)
                    from OrderItem p
                    join p.medicine m
                    join p.order order
                    where order.pharmacy = ?1""")
    public Float costTotal(Pharmacy pharmacy);
}
