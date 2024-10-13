package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void compareToTesTicketPriceLess() {
        Ticket ticket1 = new Ticket("SPB", "IST", 100, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "IST", 200, 12, 17);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestTicketPriceMore() {
        Ticket ticket1 = new Ticket("SPB", "IST", 100, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "IST", 200, 12, 17);

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestTicketPriceSame() {

        Ticket ticket1 = new Ticket("SPB", "IST", 100, 10, 14);
        Ticket ticket3 = new Ticket("SPB", "IST", 100, 16, 22);

        int expected = 0;
        int actual = ticket1.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestTicketPrice() {
        AviaSouls tickets = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "IST", 100, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "IST", 200, 12, 17);
        Ticket ticket3 = new Ticket("SPB", "IST", 100, 16, 22);
        Ticket ticket4 = new Ticket("SPB", "IST", 500, 9, 12);
        Ticket ticket5 = new Ticket("SPB", "IST", 300, 7, 10);

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        Ticket[] actual = tickets.search("SPB", "IST");
        Ticket[] expected = {ticket1, ticket3, ticket2, ticket5, ticket4};
        Assertions.assertArrayEquals(expected,actual);
    }


    @Test
    public void searchAndSortByTest() {
        AviaSouls tickets = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "IST", 100, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "IST", 200, 12, 17);
        Ticket ticket3 = new Ticket("SPB", "IST", 100, 16, 22);
        Ticket ticket4 = new Ticket("SPB", "IST", 500, 9, 12);
        Ticket ticket5 = new Ticket("SPB", "IST", 300, 7, 10);

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = tickets.searchAndSortBy("SPB", "IST", comparator);
        Ticket[] expected = {ticket4, ticket5, ticket1, ticket2, ticket3};
        Assertions.assertArrayEquals(expected,actual);
    }

}

