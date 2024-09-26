public class Room {
    private String name;
    private String descriptionOfRoom;
    private Room north, east, south, west;

    public Room(String name, String descriptionOfRoom) {
        this.name = name;
        this.descriptionOfRoom = descriptionOfRoom;
    }

    public String getName() {
        return name;
    }

    public String getDescriptionOfRoom() {
        return descriptionOfRoom;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east){
        this.east = east;
    }

    public void setSouth(Room south){
        this.south = south;
    }

    public void setWest(Room west){
        this.west = west;
    }

    public Room getNorth(){
        return north;
    }

    public Room getEast(){
        return east;
    }

    public Room getSouth(){
        return south;
    }

    public Room getWest(){
        return west;
    }
}
