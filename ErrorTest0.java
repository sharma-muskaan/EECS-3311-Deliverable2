import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test01");
        DigitalItem digitalItem6 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str7 = digitalItem6.getName();
        java.lang.String str8 = digitalItem6.getAuthor();
        java.lang.String str9 = digitalItem6.itemType;
        digitalItem6.setGenre("hi!  has been requested");
        DigitalItem digitalItem12 = new DigitalItem(digitalItem6);
        java.lang.String str13 = digitalItem12.getEdition();
        digitalItem12.setItemType("hi!  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator22 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        Visitor visitor23 = new Visitor((Account) concreteAccountDecorator22);
        visitor23.setEmail("");
        DigitalItem digitalItem32 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str33 = digitalItem32.getName();
        java.lang.String str34 = visitor23.request(digitalItem32);
        digitalItem32.author = "";
        digitalItem32.setName("hi! hi! hi!  has been requested has been requested has been requested");
        java.lang.String str39 = digitalItem32.author;
        java.lang.Object obj40 = digitalItem32.clone();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        boolean boolean41 = digitalItem12.isEqualTo(digitalItem32);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test02");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test03");
        DigitalItem digitalItem6 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str7 = digitalItem6.getName();
        java.lang.String str8 = digitalItem6.getAuthor();
        java.lang.Object obj9 = digitalItem6.clone();
        DigitalItem digitalItem10 = digitalItem6.clone();
        java.lang.String str11 = digitalItem10.author;
        java.lang.String str12 = digitalItem10.name;
        digitalItem10.itemType = "hi!";
        DigitalItem digitalItem21 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str22 = digitalItem21.getName();
        java.lang.String str23 = digitalItem21.getAuthor();
        DigitalItem digitalItem24 = digitalItem21.clone();
        digitalItem21.edition = "";
        digitalItem21.setEdition("hi! hi!  has been requested has been requested");
        digitalItem21.author = "hi!";
        digitalItem21.setName("hi! hi!  has been requested has been requested");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        boolean boolean33 = digitalItem10.isEqualTo(digitalItem21);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test04");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test05");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        Account account3 = libraryDatabase0.iterateDB("hi!  has been requested", "");
        ConcreteAccountDecorator concreteAccountDecorator10 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList11 = concreteAccountDecorator10.getPhysicalItemList();
        Faculty faculty12 = new Faculty((Account) concreteAccountDecorator10);
        faculty12.setEmail("");
        faculty12.setPassword("");
        faculty12.setAccType("");
        faculty12.setItemsBorrowed(10);
        faculty12.setPassword("");
        ListGenerator.getList(faculty12, "hi! hi!  has been requested has been requested", "hi!  has been requested", "hi!");
        java.lang.String str27 = faculty12.getAccType();
        ListGenerator.getList(faculty12, "hi! hi!  has been requested has been requested", "hi! hi!  has been requested has been requested", "  has been requested");
        AccountDecorator accountDecorator32 = new AccountDecorator((Account) faculty12);
        java.util.ArrayList<PhysicalItem> physicalItemList33 = faculty12.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadPurchasableBooks(physicalItemList33);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test06");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test07");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test08");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test09");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test10");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi!", "  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator11 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList12 = concreteAccountDecorator11.getPhysicalItemList();
        Faculty faculty13 = new Faculty((Account) concreteAccountDecorator11);
        faculty13.setEmail("");
        faculty13.setPassword("");
        java.util.ArrayList<PhysicalItem> physicalItemList18 = faculty13.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadDisabledItems(physicalItemList18);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test11");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test12");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test13");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test14");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test15");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi!", "  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator11 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        concreteAccountDecorator11.setItemsBorrowed((int) (short) -1);
        concreteAccountDecorator11.setAccountLocked(true);
        concreteAccountDecorator11.setPassword("  has been requested");
        java.util.ArrayList<PhysicalItem> physicalItemList18 = concreteAccountDecorator11.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadDisabledItems(physicalItemList18);
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test16");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.tearDown();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test17");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi!", "  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator11 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList12 = concreteAccountDecorator11.getPhysicalItemList();
        Faculty faculty13 = new Faculty((Account) concreteAccountDecorator11);
        faculty13.setEmail("");
        faculty13.setPassword("");
        faculty13.setAccType("");
        faculty13.setItemsBorrowed(10);
        faculty13.setOverdueItems((-1));
        faculty13.setAccountLocked(true);
        Faculty faculty26 = new Faculty((Account) faculty13);
        java.util.ArrayList<PhysicalItem> physicalItemList27 = faculty13.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadRentableBooks(physicalItemList27);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test18");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.tearDown();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test19");
        ConcreteAccountDecorator concreteAccountDecorator6 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        int int7 = concreteAccountDecorator6.getItemsBorrowed();
        DigitalItem digitalItem14 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str15 = digitalItem14.getName();
        concreteAccountDecorator6.openOnlineBook(digitalItem14);
        NonFaculty nonFaculty17 = new NonFaculty((Account) concreteAccountDecorator6);
        nonFaculty17.setItemsBorrowed((int) (byte) -1);
        nonFaculty17.sort();
        java.lang.String str21 = nonFaculty17.getAccType();
        DigitalItem digitalItem28 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str29 = digitalItem28.getName();
        java.lang.String str30 = digitalItem28.getAuthor();
        DigitalItem digitalItem31 = digitalItem28.clone();
        digitalItem31.setEdition("hi!  has been requested");
        DigitalItem digitalItem34 = new DigitalItem(digitalItem31);
        DigitalItem digitalItem35 = digitalItem34.clone();
        java.lang.String str36 = nonFaculty17.request(digitalItem35);
        DigitalItem digitalItem43 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str44 = digitalItem43.getName();
        java.lang.String str45 = digitalItem43.getAuthor();
        java.lang.String str46 = digitalItem43.itemType;
        nonFaculty17.subToNews(digitalItem43);
        java.lang.String str48 = nonFaculty17.getAccType();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        nonFaculty17.sort();
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test20");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test21");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi!", "  has been requested");
        Account account7 = libraryDatabase0.iterateDB("", "hi! hi! hi!  has been requested has been requested has been requested");
        ConcreteAccountDecorator concreteAccountDecorator14 = new ConcreteAccountDecorator("", "hi!", "", (int) '4', (int) '#', true);
        NonFaculty nonFaculty15 = new NonFaculty((Account) concreteAccountDecorator14);
        int int16 = concreteAccountDecorator14.getOverdueItems();
        java.util.ArrayList<PhysicalItem> physicalItemList17 = concreteAccountDecorator14.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadDisabledItems(physicalItemList17);
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test22");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test23");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test24");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test25");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test26");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("", "hi! hi!  has been requested has been requested hi! hi! has been requested has been requested");
        ConcreteAccountDecorator concreteAccountDecorator11 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList12 = concreteAccountDecorator11.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadDisabledItems(physicalItemList12);
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test27");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test28");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi! hi! hi!  has been requested has been requested has been requested", "hi!  has been requested");
        Account account7 = libraryDatabase0.iterateDB("", "  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator14 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList15 = concreteAccountDecorator14.getPhysicalItemList();
        concreteAccountDecorator14.setAccountLocked(true);
        int int18 = concreteAccountDecorator14.getOverdueItems();
        concreteAccountDecorator14.setEmail("hi! hi!  has been requested has been requested");
        boolean boolean21 = concreteAccountDecorator14.isAccountLocked();
        java.util.ArrayList<PhysicalItem> physicalItemList22 = concreteAccountDecorator14.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadDisabledItems(physicalItemList22);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test29");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test30");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        Account account3 = libraryDatabase0.iterateDB("hi!  has been requested", "");
        libraryDatabase0.purgeFinishedCourses();
        Account account7 = libraryDatabase0.iterateDB("hi! hi! has been requested", "  has been requested  has been requested");
        Account account10 = libraryDatabase0.iterateDB("  has been requested", "  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator17 = new ConcreteAccountDecorator("", "hi!", "", (int) '4', (int) '#', true);
        Visitor visitor18 = new Visitor((Account) concreteAccountDecorator17);
        concreteAccountDecorator17.setAccType("");
        Visitor visitor21 = new Visitor((Account) concreteAccountDecorator17);
        concreteAccountDecorator17.setAccountLocked(true);
        concreteAccountDecorator17.printReqs();
        java.util.ArrayList<PhysicalItem> physicalItemList25 = concreteAccountDecorator17.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadRentableBooks(physicalItemList25);
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test31");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.showPurchasableItems();
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test32");
        DigitalItem digitalItem6 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str7 = digitalItem6.getName();
        java.lang.String str8 = digitalItem6.getAuthor();
        DigitalItem digitalItem9 = digitalItem6.clone();
        digitalItem9.setEdition(" hi! hi!  has been requested has been requested has been requested");
        DigitalItem digitalItem18 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str19 = digitalItem18.getName();
        java.lang.String str20 = digitalItem18.getAuthor();
        DigitalItem digitalItem21 = digitalItem18.clone();
        digitalItem21.setEdition("hi!  has been requested");
        DigitalItem digitalItem24 = new DigitalItem(digitalItem21);
        java.lang.String str25 = digitalItem24.getItemType();
        digitalItem24.edition = "";
        digitalItem24.setPublisherName("  has been requested  has been requested  has been requested");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        boolean boolean30 = digitalItem9.isEqualTo(digitalItem24);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test33");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi! hi! hi!  has been requested has been requested has been requested", "hi!  has been requested");
        Account account7 = libraryDatabase0.iterateDB("", "  has been requested");
        Account account10 = libraryDatabase0.iterateDB("", "hi!  has been requested  has been requested");
        libraryDatabase0.purgeFinishedCourses();
        ConcreteAccountDecorator concreteAccountDecorator18 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList19 = concreteAccountDecorator18.getPhysicalItemList();
        Faculty faculty20 = new Faculty((Account) concreteAccountDecorator18);
        faculty20.setEmail("");
        faculty20.setPassword("");
        faculty20.setAccType("");
        faculty20.setItemsBorrowed(10);
        faculty20.setOverdueItems((-1));
        faculty20.setAccountLocked(true);
        Faculty faculty33 = new Faculty((Account) faculty20);
        java.util.ArrayList<PhysicalItem> physicalItemList34 = faculty33.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadRentableBooks(physicalItemList34);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test34");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.tearDown();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test35");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test36");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.tearDown();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test37");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test38");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("", "hi! hi!  has been requested has been requested hi! hi! has been requested has been requested");
        Account account7 = libraryDatabase0.iterateDB("hi!  has been requested  has been requested", "hi! hi!  has been requested has been requested hi! hi! has been requested has been requested  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator14 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList15 = concreteAccountDecorator14.getPhysicalItemList();
        Faculty faculty16 = new Faculty((Account) concreteAccountDecorator14);
        faculty16.setEmail("");
        faculty16.setPassword("");
        faculty16.setAccType("");
        faculty16.setItemsBorrowed(10);
        java.util.ArrayList<Course> courseList25 = faculty16.getCurrentCourses();
        ConcreteAccountDecorator concreteAccountDecorator32 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList33 = concreteAccountDecorator32.getPhysicalItemList();
        concreteAccountDecorator32.setOverdueItems(0);
        concreteAccountDecorator32.setOverdueItems(0);
        DigitalItem digitalItem44 = new DigitalItem("hi!", "", "", "", "hi!", "");
        DigitalItem digitalItem51 = new DigitalItem("hi!", "", "", "", "hi!", "");
        java.lang.String str52 = digitalItem51.getName();
        digitalItem51.author = "";
        boolean boolean55 = digitalItem44.isEqualTo(digitalItem51);
        concreteAccountDecorator32.openOnlineBook(digitalItem51);
        DigitalItem digitalItem57 = new DigitalItem(digitalItem51);
        faculty16.openOnlineBook(digitalItem51);
        int int59 = faculty16.getItemsBorrowed();
        java.util.ArrayList<PhysicalItem> physicalItemList60 = faculty16.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadRentableBooks(physicalItemList60);
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test39");
        JUnit_Test jUnit_Test0 = new JUnit_Test();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        jUnit_Test0.tearDown();
        jUnit_Test0.testAdditionalValidationWithInvalidEmail();
        jUnit_Test0.testIsValidEmailFalse();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        jUnit_Test0.testShowRecommendations_recommendationsShown();
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test40");
        LibraryDatabase libraryDatabase0 = LibraryDatabase.getInstance();
        libraryDatabase0.purgeFinishedCourses();
        Account account4 = libraryDatabase0.iterateDB("hi! hi! hi!  has been requested has been requested has been requested", "hi!  has been requested");
        Account account7 = libraryDatabase0.iterateDB("", "  has been requested");
        Account account10 = libraryDatabase0.iterateDB("hi!   has been requested has been requested", "hi! hi!  has been requested has been requested hi! hi! has been requested has been requested");
        libraryDatabase0.purgeFinishedCourses();
        Account account14 = libraryDatabase0.iterateDB("hi! hi! has been requested", "  has been requested");
        ConcreteAccountDecorator concreteAccountDecorator21 = new ConcreteAccountDecorator("hi!", "hi!", "hi!", (int) (byte) -1, (int) (byte) 100, true);
        java.util.ArrayList<PhysicalItem> physicalItemList22 = concreteAccountDecorator21.getPhysicalItemList();
        concreteAccountDecorator21.setAccountLocked(true);
        int int25 = concreteAccountDecorator21.getOverdueItems();
        concreteAccountDecorator21.setEmail("hi! hi!  has been requested has been requested");
        boolean boolean28 = concreteAccountDecorator21.isAccountLocked();
        java.util.ArrayList<PhysicalItem> physicalItemList29 = concreteAccountDecorator21.getPhysicalItemList();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        libraryDatabase0.loadRentableBooks(physicalItemList29);
    }
}

