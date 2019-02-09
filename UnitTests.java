package hw5;
import java.util.*;
import java.io.*;
public class UnitTests {
	
	public static void main(String[] args)
	throws IOException {
		runTests();
	}
	
	
	private static void runTests()
	throws IOException {
		runAdvRooms();
	//	runAdvObject();
	}
	
	
	/**
	 * Runs AdvRooms Unit test
	 * @throws FileNotFoundException
	 */
	private static void runAdvRooms()
	throws IOException {
		Scanner sc = new Scanner(new File("SmallRooms.txt"));
		advRooms(sc);
	}
	
	/**
	 * Unit test AdvRooms
	 * @param sc
	 */
	private static void advRooms(Scanner sc) throws IOException { //ADD CHECK OBJECTS
		AdvRoom[] rooms = {AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc),
							AdvRoom.readFromFile(sc)}; //WHY DOESNT LAST WORK??
		for (AdvRoom room: rooms) {
			printAdvRoom(room);
		}
	}
	
	/**
	 * Prints AdvRooms
	 * @param room
	 */
	private static void printAdvRoom(AdvRoom room) {
		System.out.println(room.getRoomNumber());
		System.out.println(room.getName());
		for (String line: room.getDescription()) {
			System.out.println(line);
		}
		System.out.println("-----");
		for (AdvMotionTableEntry each: room.getMotionTable()) {
			String direction = each.getDirection();
			int nextRoom = each.getDestinationRoom();
			String key = each.getKeyName();
			if (key == null) {
				System.out.printf("%-9s %d", direction, nextRoom);
				System.out.println();
			} else {
				System.out.printf("%-9s %d/%s", direction, nextRoom, key);
				System.out.println();
			}
		
		}
		int count = room.getObjectCount();
		for (int i = 0; i < count; i++) {
			AdvObject obj = room.getObject(i);
			System.out.println(obj);
		}
		System.out.println();
	}


}
