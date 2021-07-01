package com.yener.testproject.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sun.misc.resources.Messages_pt_BR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

public class SampleMockWithCustomerOrderTest {

    @Test
    void addOrderToCustomer() {
        final Inventory inventoryMock= Mockito.mock(Inventory.class);
        Mockito.when(inventoryMock.isStockAvailable("item1","item2")).thenReturn(true);
        Mockito.when(inventoryMock.isStockAvailable("item3")).thenReturn(false);

        Customer customer=new Customer(inventoryMock);
        assertTrue(customer.addOrder(new Order(Arrays.asList("item1","item2"))));
        assertFalse(customer.addOrder(new Order(Arrays.asList("item3"))));

        Mockito.verify(inventoryMock,Mockito.times(1)).isStockAvailable(eq("item1"),eq("item2"));
        Mockito.verify(inventoryMock,Mockito.times(1)).isStockAvailable(eq("item3"));

    }

    private class Customer {
        final Inventory inventory;

        public Customer(Inventory inventory) {
            this.inventory = inventory;
        }

        boolean addOrder(Order order) {
            if (!inventory.isStockAvailable(order.items.toArray(new String[]{}))) {
                return false;
            }
            return true;
        }
    }

    private class Order {
        List<String> items = new ArrayList<>();

        Order(List<String> items) {
            this.items.addAll(items);
        }
    }

    private interface Inventory {
        boolean isStockAvailable(String... items);
    }
}
