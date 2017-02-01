package com.yamuna.dao;

import java.util.Iterator;
import java.util.List;

import com.yamuna.model.OrderRecords;

public class TestOrderRecordsDAO {
	public static void main(final String[] args) {

		OrderRecordsDAO orderrecordsDAO = new OrderRecordsDAO();
	 //OrderDetailsDAO.save(orderItem);
	// OrderDetailsDAO.delete(5);
		
	List<OrderRecords> list = orderrecordsDAO.list();
	Iterator i=list.iterator();
	while(i.hasNext())
	{
		OrderRecords orderrecords = (OrderRecords) i.next();
		System.out.println(orderrecords.getOrderId()+"\t"+orderrecords.getSeatNo()+"\t"+orderrecords.getFoodOrdered()+"\t"
				+"\t"+orderrecords.getQuantity()+"\t"+orderrecords.getOrderDate()+"\t"+orderrecords.getOrderStatus()+"\t"+orderrecords.getBillStatus());
		
		
	}

}
}