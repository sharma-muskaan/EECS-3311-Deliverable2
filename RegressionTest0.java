import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        Account account0 = null;
        ListGenerator.getList(account0, "hi!", "hi!", "");
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        // The following exception was thrown during execution in test generation
        try {
            jUnit_Test0.warningMessageTest();
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index 0 out of bounds for length 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
        // Expected exception.
        }
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        Account account0 = null;
        Faculty faculty1 = new Faculty(account0);
        DigitalItem[] digitalItemArray2 = new DigitalItem[] {};
        java.util.ArrayList<DigitalItem> digitalItemList3 = new java.util.ArrayList<DigitalItem>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<DigitalItem>) digitalItemList3, digitalItemArray2);
        DigitalItem digitalItem5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = faculty1.newerEdition(digitalItemList3, digitalItem5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Account.newerEdition(java.util.ArrayList, DigitalItem)\" because \"this.wrappee\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(digitalItemArray2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        Student student0 = null;
        ListGenerator.getList(student0, "", "", "hi!");
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        Book book0 = null;
        // The following exception was thrown during execution in test generation
        try {
            Book book1 = new Book(book0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"itemType\" because \"item\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        Visitor visitor7 = new Visitor((Account) concreteAccountDecorator6);
        DigitalItem digitalItem8 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = concreteAccountDecorator6.request(digitalItem8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"DigitalItem.getItemType()\" because \"b\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        LibraryHomePage libraryHomePage0 = new LibraryHomePage();
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList7 = concreteAccountDecorator6.getPhysicalItemList();
        concreteAccountDecorator6.setOverdueItems(0);
        concreteAccountDecorator6.setOverdueItems(0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(physicalItemList7);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList7 = concreteAccountDecorator6.getPhysicalItemList();
        DigitalItem digitalItem8 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = concreteAccountDecorator6.request(digitalItem8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"DigitalItem.getItemType()\" because \"b\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(physicalItemList7);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList7 = concreteAccountDecorator6.getPhysicalItemList();
        concreteAccountDecorator6.setOverdueItems(0);
        PhysicalItem physicalItem10 = null;
        concreteAccountDecorator6.rentBook(physicalItem10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(physicalItemList7);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        CD cD0 = null;
        // The following exception was thrown during execution in test generation
        try {
            CD cD1 = new CD(cD0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"itemType\" because \"item\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("", "hi!", "", (int) '4', (int) '#', true);
        Visitor visitor7 = new Visitor((Account) concreteAccountDecorator6);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        DVDFactory dVDFactory0 = new DVDFactory();
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        DigitalItem digitalItem0 = null;
        // The following exception was thrown during execution in test generation
        try {
            DigitalItem digitalItem1 = new DigitalItem(digitalItem0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"itemType\" because \"item\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        BookFactory bookFactory0 = new BookFactory();
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        ListGenerator listGenerator0 = new ListGenerator();
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        java.util.Date date8 = null;
        CD cD11 = new CD("", "", "", "", "", "", "", 10, date8, true, (double) 1.0f);
        cD11.itemID = "hi!";
        double double14 = cD11.price;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 1.0d + "'", double14 == 1.0d);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        CDFactory cDFactory0 = new CDFactory();
        java.util.Date date9 = null;
        CD cD12 = cDFactory0.getPhysicalItem("", "", "", "", "hi!", "hi!", "", (int) (short) 10, date9, true, (double) ' ');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(cD12);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList7 = concreteAccountDecorator6.getPhysicalItemList();
        Faculty faculty8 = new Faculty((Account) concreteAccountDecorator6);
        faculty8.setEmail("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(physicalItemList7);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        DigitalItem digitalItem1 = null;
        java.util.Date date2 = null;
        Course course3 = new Course("", digitalItem1, date2);
        java.util.Date date4 = course3.getCourseEndDate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(date4);
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        java.util.Date date8 = null;
        CD cD11 = new CD("", "", "", "", "", "", "", 10, date8, true, (double) 1.0f);
        java.lang.String str12 = cD11.libLocation;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        java.util.Date date8 = null;
        CD cD11 = new CD("", "", "", "", "", "", "", 10, date8, true, (double) 1.0f);
        cD11.itemID = "hi!";
        ConcreteAccountDecorator concreteAccountDecorator20 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        int int21 = concreteAccountDecorator20.getItemsBorrowed();
        cD11.rentCopy((Account) concreteAccountDecorator20);
        ConcreteAccountDecorator concreteAccountDecorator29 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList30 = concreteAccountDecorator29.getPhysicalItemList();
        Faculty faculty31 = new Faculty((Account) concreteAccountDecorator29);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str32 = cD11.warningString((Account) concreteAccountDecorator29);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Date.getTime()\" because \"this.dueDate\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(physicalItemList30);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        java.util.Date date8 = null;
        CD cD11 = new CD("", "", "", "", "", "", "", 10, date8, true, (double) 1.0f);
        cD11.itemID = "hi!";
        ConcreteAccountDecorator concreteAccountDecorator20 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        int int21 = concreteAccountDecorator20.getItemsBorrowed();
        cD11.rentCopy((Account) concreteAccountDecorator20);
        DigitalItem[] digitalItemArray23 = new DigitalItem[] {};
        java.util.ArrayList<DigitalItem> digitalItemList24 = new java.util.ArrayList<DigitalItem>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<DigitalItem>) digitalItemList24, digitalItemArray23);
        DigitalItem digitalItem26 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean27 = concreteAccountDecorator20.newerEdition(digitalItemList24, digitalItem26);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"DigitalItem.getEdition()\" because \"selectedItem\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(digitalItemArray23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(libraryDatabase0);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        Account account0 = null;
        Faculty faculty1 = new Faculty(account0);
        DigitalItem digitalItem3 = null;
        java.util.Date date4 = null;
        Course course5 = new Course("", digitalItem3, date4);
        java.util.Date date6 = course5.getCourseEndDate();
        Course[] courseArray7 = new Course[] { course5 };
        java.util.ArrayList<Course> courseList8 = new java.util.ArrayList<Course>();
        boolean boolean9 = java.util.Collections.addAll((java.util.Collection<Course>) courseList8, courseArray7);
        faculty1.setCurrentCourses(courseList8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(date6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(courseArray7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList7 = concreteAccountDecorator6.getPhysicalItemList();
        concreteAccountDecorator6.setOverdueItems(0);
        DigitalItem digitalItem10 = null;
        concreteAccountDecorator6.subToNews(digitalItem10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(physicalItemList7);
    }
}

