package org.ICE24;


public class Main {
    public static void main(String[] args) {


        //User user1 = LoginService.createUser();

        UserShop persshop = new UserShop();


        persshop.viewAllItems();

        /*Shirt bluse = new Shirt("slidt","men sej",1000,0);
        System.out.println(bluse);
        Pants buks = new Pants("nye","blå",1000000,5);
        System.out.println(buks);
        Hat hat = new Hat("slasket", "grå cool hul i midten",25);
        System.out.println(hat);
         */

        persshop.createItem();
        persshop.viewAllItems();
    }
}
