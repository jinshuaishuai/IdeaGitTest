package com.pattern.decorate;

/**
 * @author shuai.jin
 * @date 2020/9/16 10:59
 */
public class DecorateHouse extends House {

    private House house;

    public DecorateHouse(House house) {
        this.house = house;
    }

    @Override
    public void live() {
        house.live();
        System.out.println("房子还可以用来挡风御寒");
    }

    public static void main(String[] args) {
        RedHouse redHouse = new RedHouse();
        House house = new DecorateHouse(redHouse);
        house.live();
    }
}
