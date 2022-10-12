import java.util.ArrayList;

public class Map {

    private Room starterRoom;

    public void createMap(){
        // Creating room objects
        Room room1 = new Room("road",
                "you are on the road outside the city, " +
                        "you are the only one around, everything is deserted.");
        Room room2 = new Room("abandoned kiosk",
                "there are broken bottles everywhere, " +
                        "but it looks like something can still be scavenged..");
        Room room3 = new Room("garden outside the store",
                "there is an old fountain," +
                        " it seems like there is something in the muddy water..");
        Room room4 = new Room("road",
                "the road continues. no sign of life, but at the side of the road, you discover a dead person" +
                        " you walk closer to it and see that it is a dead person, who has been laying" +
                        " there for some time now and has a picture of his family");
        Room room5 = new Room("cellar in hotel",
                "the cellar has a weird smell, almost like fresh made food. " +
                        "there are boxes that belong to the bar, and a lot of ingredients for the kitchen. " +
                        "this cellar has not been visited since the apocalypse.");
        Room room6 = new Room("forest",
                "ah, a lovely forest. the only place left is that still has some life in the form" +
                        " of growing trees and plants. fresh blueberries are growing. a small well is on the tracks," +
                        " it doesn't look that deep, but seems to continue at the bottom.");
        Room room7 = new Room("In front of the hotel",
                "the end of the road. a big hotel with a giant neon light half lit is in front of you. " +
                        "the windows shattered, but sounds emerges from inside.");
        Room room8 = new Room("hotel lobby",
                "the lobby looks very cozy, with sofas and an old bar. ");
        Room room9 = new Room("tunnel in the well",
                "there is very dark down here, but a little light at the end points to a staircase. somethings else is shining down here..");

        // Setting directions for each room
        room1.setEast(room2);
        room1.setSouth(room4);

        // Room2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.createMeleeWeapon("hobbyknife", "used to cut up boxes and other useful stuff", 2);
        room2.createFood("chocolate", "on the floor besides the spilled milk. might be bad for you..",-8);
        room2.createFood("beer", "in the cooling section. will it still get you drunk?", -12);
        room2.createEnemy("Ali", "behind the counter, with a snus in the upper lip.", 25, new RangedWeapon("Deagle", "enormous gun that deals heavy damage", 5, 6), room2);


        // Room3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.createMeleeWeapon("machette", "shining in the water by the fountain. looks sharp enough..",4);

        // Room4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.createFood("snus", "on the road beside the not so lively roadman, looks used..", 2);

        // Room5
        room5.setSouth(room8);
        room5.createEnemy("Kris", "getting a haircut, whilst eating a durum that he wields as a weapon once you approach..", 100, new MeleeWeapon("Durum", "Slasket durum, ekstra dres og kød", 3), room5);


        // Room6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.createFood("blueberries", "at the bush, those look fresh..", 5);
        room6.createFood("cranberries", "at another bush, nice color..", 8);
        room6.createFood("mushrooms", "growing on the ground, are they good for you?", -100);

        // Room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Room 8
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.createFood("chips", "on one of tables in the lobby, that'll do..",8);
        room8.createFood("vodka", "behind the bar, a whole bottle!",-5);

        // Room 9
        room9.setWest(room8);
        room9.setNorth(room6);
        room9.createEnemy("rat", "rabid rat in the well, oh well..", 12, new MeleeWeapon("claws", "the rats claws..", 3 ), room9);
        room9.createRangeWeapon("slingshot", "in the mud in the well, could play useful...", 3, 9);

        // Setting starterRoom to room1 at the start
        starterRoom = room1;

    }

    public Room getStarterRoom() {
        return starterRoom;
    }

}
