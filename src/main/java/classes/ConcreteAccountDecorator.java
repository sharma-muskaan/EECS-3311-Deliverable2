package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ConcreteAccountDecorator implements Account {
   protected String email;
   protected String password;
   protected String accType;
   protected int itemsBorrowed;
   protected int overdueItems;
   protected boolean accountLocked;
   protected ArrayList<DigitalItem> digitalItemList;
   protected ArrayList<PhysicalItem> physicalItemList;
   private static LibraryDatabase database;
   protected ArrayList<DigitalItem> reqs = new ArrayList();

   public ConcreteAccountDecorator(String var1, String var2, String var3, int var4, int var5, boolean var6) throws Exception {
      this.email = var1;
      this.password = var2;
      this.accType = var3;
      this.itemsBorrowed = var4;
      this.overdueItems = var5;
      this.accountLocked = var6;
      this.digitalItemList = new ArrayList();
      this.physicalItemList = new ArrayList();
      database = LibraryDatabase.getInstance();
   }

   public void openOnlineBook(DigitalItem var1) {
   }

   public ArrayList<Item> search(String var1) {
      return null;
   }

   public void subToNews(DigitalItem var1) {
   }

   public void rentBook(PhysicalItem var1) {
   }

   public void returnBook(PhysicalItem var1) {
   }

   public void purchaseItem(Item var1) {
   }

   public ArrayList<PhysicalItem> getPhysicalItemList() {
      return this.physicalItemList;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPass() {
      return this.password;
   }

   public String getAccType() {
      return this.accType;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setAccType(String var1) {
      this.accType = var1;
   }

   public int getItemsBorrowed() {
      return this.itemsBorrowed;
   }

   public void setItemsBorrowed(int var1) {
      this.itemsBorrowed = var1;
   }

   public int getOverdueItems() {
      return this.overdueItems;
   }

   public void setOverdueItems(int var1) {
      this.overdueItems = var1;
      if (var1 > 3) {
         this.setAccountLocked(true);
      }

   }

   public boolean isAccountLocked() {
      return this.accountLocked;
   }

   public void setAccountLocked(boolean var1) {
      this.accountLocked = var1;
   }

   public String request(DigitalItem var1) {
      String var10000;
      if (var1.getItemType().equals("Textbook")) {
         this.reqs.add(var1);
         var10000 = var1.getItemType();
         return var10000 + " " + var1.getName() + " " + var1.getEdition() + " has been requested";
      } else {
         this.reqs.add(var1);
         var10000 = var1.getItemType();
         return var10000 + " " + var1.getName() + " has been requested";
      }
   }

   public void sort() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.reqs.size(); ++var2) {
         if (((DigitalItem)this.reqs.get(var2)).getGenre().equals("Educational")) {
            Collections.swap(this.reqs, var1, var2);
            ++var1;
         }
      }

   }

   public void printReqs() {
      System.out.println("Requested Items Queue (Educational Textbooks have higher priority):");
      int var1 = 0;
      Iterator var2 = this.reqs.iterator();

      while(var2.hasNext()) {
         DigitalItem var3 = (DigitalItem)var2.next();
         ++var1;
         System.out.println("" + var1 + ". " + var3.getItemType() + " " + var3.getName());
      }

   }

   public boolean newerEdition(ArrayList<DigitalItem> var1, DigitalItem var2) {
      String var3 = var2.getEdition().replaceAll("[^\\d.]", "");
      int var4 = Integer.parseInt(var3);
      Iterator var5 = var1.iterator();

      int var8;
      do {
         if (!var5.hasNext()) {
            return false;
         }

         DigitalItem var6 = (DigitalItem)var5.next();
         String var7 = var6.getEdition().replaceAll("[^\\d.]", "");
         var8 = Integer.parseInt(var7);
      } while(var8 <= var4);

      return true;
   }

   public void notifyNewEdition(ArrayList<DigitalItem> var1, DigitalItem var2) {
      if (this.newerEdition(var1, var2)) {
         System.out.println("New edition available!");
      }

   }

   public boolean textbookAvailable(ArrayList<DigitalItem> var1, String var2) {
      Iterator var3 = var1.iterator();

      DigitalItem var4;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var4 = (DigitalItem)var3.next();
      } while(!var4.getName().equalsIgnoreCase(var2));

      return true;
   }

   public void notifyManagement(ArrayList<DigitalItem> var1, String var2) {
      if (!this.textbookAvailable(var1, var2)) {
         System.out.println("Management notfication: textbook not available!");
      }

   }
}
