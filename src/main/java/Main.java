import model.IsoMessageData;
import service.IsoCrudService;
import service.IsoParserService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IsoCrudService crudService = new IsoCrudService();
        IsoParserService parserService = new IsoParserService();

        while (true) {
            System.out.println("\n1. Create ISO Message");
            System.out.println("2. View All Messages");
            System.out.println("3. Update Message");
            System.out.println("4. Delete Message");
            System.out.println("5. Pack ISO Message");
            System.out.println("6. Unpack ISO Packet");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        IsoMessageData data = readMessage(scanner);
                        crudService.create(data);
                        System.out.println("Message created.");
                        break;

                    case 2:
                        List<IsoMessageData> all = crudService.getAll();
                        if (all.isEmpty()) {
                            System.out.println("No messages found.");
                        } else {
                            for (IsoMessageData msg : all) {
                                System.out.println(msg);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        IsoMessageData updated = readMessage(scanner);
                        updated.setId(updateId);

                        if (crudService.update(updateId, updated)) {
                            System.out.println("Updated.");
                        } else {
                            System.out.println("Message not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        if (crudService.delete(deleteId)) {
                            System.out.println("Deleted.");
                        } else {
                            System.out.println("Message not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter ID to pack: ");
                        int packId = Integer.parseInt(scanner.nextLine());
                        IsoMessageData messageToPack = crudService.getById(packId);

                        if (messageToPack != null) {
                            String packedHex = parserService.packMessage(messageToPack);
                            System.out.println("Packed ISO8583 Hex:");
                            System.out.println(packedHex);
                        } else {
                            System.out.println("Message not found.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter ISO hex packet: ");
                        String hexPacket = scanner.nextLine();
                        parserService.unpackMessage(hexPacket);
                        break;

                    case 7:
                        System.out.println("Bye.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static IsoMessageData readMessage(Scanner scanner) {
        IsoMessageData data = new IsoMessageData();

        System.out.print("ID: ");
        data.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("MTI: ");
        data.setMti(scanner.nextLine());

        System.out.print("Field 2 (PAN): ");
        data.setField2(scanner.nextLine());

        System.out.print("Field 3 (Processing Code): ");
        data.setField3(scanner.nextLine());

        System.out.print("Field 4 (Amount): ");
        data.setField4(scanner.nextLine());

        System.out.print("Field 7 (Transmission DateTime): ");
        data.setField7(scanner.nextLine());

        System.out.print("Field 11 (STAN): ");
        data.setField11(scanner.nextLine());

        System.out.print("Field 41 (Terminal ID): ");
        data.setField41(scanner.nextLine());

        System.out.print("Field 49 (Currency Code): ");
        data.setField49(scanner.nextLine());

        return data;
    }
}