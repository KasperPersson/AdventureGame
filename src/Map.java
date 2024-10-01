public class Map {
    public Room createRooms() {
        Room room1 = new Room("Room1", " You find yourself in a dimly lit cavern, the air damp and musty. " +
                "The walls are rough and jagged, adorned with ancient markings that seem to tell stories \nof a " +
                "long-forgotten past. The ground is uneven, scattered with small rocks and loose soil. " +
                "A faint sound of dripping water echoes through the space. There's a strange, earthy \nscent " +
                "lingering in the air, but you can't quite place it. As you venture deeper, you sense that this " +
                "is no ordinary cave.");
        Room room2 = new Room("Room2. ", " The passage narrows, forcing you to stoop as you make your way through. " +
                "The walls here are smoother, as if worn down by something large moving \nthrough over the years. " +
                "In the corner, you notice fragments of what appears to be large, broken shells. The pieces are " +
                "greenish and emit a faint sulfurous smell. \nYou can't help but feel an ominous presence, as if " +
                "something has been watching this path for a long time");
        Room room3 = new Room("Room3", " This room opens up into a large chamber, with the ceiling arching high " +
                "above you. Scattered around are more broken shells, some with claw marks on them. The air is\n " +
                "heavy with the pungent smell of decay and the faintest hint of sulfur. In the center, there is a " +
                "deep groove in the ground, as if something massive had been resting here. You notice scratch marks" +
                "on the walls and burnt patches on the floor. The sense of foreboding is stronger here, and you " +
                "begin to wonder what kind of creature could have called this place home.");
        Room room4 = new Room("Room4", " You enter a long, winding corridor. The walls are covered in a strange, " +
                "glossy substance that catches the light of your torch. As you step forward, your foot slips on\n " +
                "something wet. Looking down, you see a thick, viscous liquid smeared on the floor. It has a " +
                "sickly-sweet odor mixed with a sharp, acrid tang. You notice the remnants of what appear to be " +
                "snake eggs, but they are far larger than any snake you’ve ever seen. The further you go, the " +
                "stronger the smell becomes, making your eyes water.");
        Room room5 = new Room("Room5", " You step into the largest chamber you've seen yet. The air is warm and " +
                "dry, carrying the smell of something ancient and powerful. In the center of the room, surrounded \n" +
                "by a bed of smoldering coals, lies a massive, shimmering egg. It's unlike anything you've ever " +
                "seen, covered in iridescent scales that shift colors in the dim light. As you approach, the ground " +
                "trembles slightly, and you can feel the pulse of life emanating from within. This is no ordinary " +
                "egg; this is the egg of a dragon, not yet hatched. A sense of awe and fear washes over you as you " +
                "realize you are standing in the heart of the dragon's lair");
        Room room6 = new Room("Room6", " You follow a trail of burnt ground and charred rocks. The walls are " +
                "blackened as if seared by intense heat. Ashes cover the floor, and you can see the remnants of \n" +
                "scorched bones scattered around. The air is thick with the smell of burnt flesh and smoke. It's " +
                "clear that this place has seen fire recently, and whatever caused it is still nearby. As you move " +
                "forward, the path ahead seems to glow faintly with residual heat.");
        Room room7 = new Room("Room7", " This chamber is darker than the others, and the shadows seem to shift and " +
                "move on their own. You hear faint whispers echoing through the darkness, but you can't tell where \n" +
                "they are coming from. The air is cool and has a metallic taste. Every so often, you catch a glimpse" +
                "of something slithering just out of sight. The walls are marked with deep grooves, and the floor is " +
                "covered in a thick layer of dust and debris. You have the uneasy feeling that you are being watched.");
        Room room8 = new Room("Room8", " You stumble upon what seems to be a hidden nook within the cave system. " +
                "The walls here are smoother, almost polished, and there are faint signs of some ancient " +
                "ritualistic carvings. In the corner of the room, partially hidden under a pile of rubble, you \n" +
                "find more broken shells, but these are different. They seem more recent, and the smell here is " +
                "overpowering. There’s a sense of urgency in the air, as if something is about to happen. The " +
                "ground trembles slightly beneath your feet, and you feel drawn to a small, concealed passage at the far end of the room.");
        Room room9 = new Room("Room9", " The air is cold and still, and a fine " +
                "mist covers the ground. In the center of the room lies a massive skeleton, its bones blackened \n" +
                "and twisted. It looks like it belonged to a giant serpent. The skull is massive, with sharp, " +
                "protruding fangs, and it seems to be guarding something. You notice a faint glow coming from " +
                "beneath its ribcage, and as you step closer, you see that it is a clutch of dragon eggs. They " +
                "are cracked and empty, but one is different from the others. It has a faint, magical aura " +
                "around it, as if it has been blessed or cursed. You can feel a surge of power as you gaze upon " +
                "it, realizing that this is the last remnant of the dragon’s lineage.");


//       currentRoom = room1;

        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItem(new Item("Lamp", "A glowing lamp"));

        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItem(new Item("Cape", "A magical cape"));

        room3.setSouth(room6);
        room3.setWest(room2);
        room3.addItem(new Item("Map", "A ripped map"));

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setSouth(room9);
        room6.setNorth(room3);

        room7.setEast(room8);
        room7.setNorth(room4);

        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);

        return room1;

    }

}
