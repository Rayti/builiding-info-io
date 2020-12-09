package pl.put.poznan.transformer.model;

import pl.put.poznan.transformer.logic.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class Level extends Location {

    private List<Room> roomList;

    public Level(long id, String name, Room[] rooms) {
        super(id, name);
        roomList = new ArrayList<>();
        roomList.addAll(List.of(rooms));
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    private float calculate(ToDoubleFunction<Room> roomToDoubleFunction) {
        return (float)roomList.stream()
                .mapToDouble(roomToDoubleFunction)
                .sum();
    }

    @Override
    public float calculateArea() {
        return calculate(Room::calculateArea);
    }

    @Override
    public float calculateVolume() {
        return calculate(Room::calculateVolume);
    }

    @Override
    public float calculateLight() {
        int roomAmount = roomList.size();
        return roomAmount > 0 ? calculate(Room::calculateLight)/roomAmount : 0;
    }

    @Override
    public float calculateHeating() {
        int roomAmount = roomList.size();
        return roomAmount > 0 ? calculate(Room::calculateHeating)/roomAmount : 0;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLevel(this);
    }


}
