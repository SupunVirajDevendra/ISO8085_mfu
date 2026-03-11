# ISO 8583 CMS Demo

A comprehensive Java-based Card Management System (CMS) demonstration application designed for creating, managing, and processing ISO 8583 financial transaction messages using the industry-standard jPOS library.

## Project Description

This CMS demo application serves as a practical implementation of ISO 8583 message handling, providing developers and financial technology professionals with a hands-on tool for understanding and working with financial transaction protocols. The application simulates real-world payment processing scenarios by offering complete lifecycle management of ISO 8583 messages - from creation and storage to packing for network transmission and unpacking for analysis.

Built with enterprise-grade Java and powered by the robust jPOS framework, this system demonstrates key concepts in electronic payment processing including message formatting, field validation, hexadecimal encoding/decoding, and transaction data management. The intuitive command-line interface makes it accessible for learning, testing, and prototyping payment system integrations.

This project provides a command-line interface (CLI) for ISO 8583 message operations including:
- CRUD operations for ISO message data
- Packing ISO messages to hexadecimal format
- Unpacking hexadecimal packets back to readable ISO messages
- Support for common ISO 8583 fields

## Features

- **Create, Read, Update, Delete** ISO 8583 messages
- **Pack** ISO messages to hexadecimal format for transmission
- **Unpack** hexadecimal packets to view message contents
- **Interactive CLI** menu system for easy navigation
- **In-memory storage** for message management

## Supported ISO 8583 Fields

- **MTI** (Message Type Indicator)
- **Field 2** - Primary Account Number (PAN)
- **Field 3** - Processing Code
- **Field 4** - Transaction Amount
- **Field 7** - Transmission Date & Time
- **Field 11** - System Trace Audit Number (STAN)
- **Field 41** - Card Acceptor Terminal ID
- **Field 49** - Currency Code


## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Installation & Setup

1. **Clone or download** the project
2. **Navigate** to the project directory:
   ```bash
   cd cmsdemo
   ```

3. **Build the project** using Maven:
   ```bash
   mvn clean compile package
   ```

4. **Run the application**:
   ```bash
   java -cp target/cmsdemo-1.0-SNAPSHOT.jar Main
   ```

## Usage

### Interactive Menu

Once started, you'll see the following menu:

```
1. Create ISO Message
2. View All Messages
3. Update Message
4. Delete Message
5. Pack ISO Message
6. Unpack ISO Packet
7. Exit
```

### Creating Messages

1. Select option **1** to create a new ISO message
2. Enter the required fields:
   - ID (unique identifier)
   - MTI (e.g., 0200 for authorization request)
   - Field 2 (PAN - 16-19 digits)
   - Field 3 (Processing Code - 6 digits)
   - Field 4 (Amount - 12 digits, no decimal)
   - Field 7 (Transmission datetime - MMDDhhmmss)
   - Field 11 (STAN - 6 digits)
   - Field 41 (Terminal ID - 8 characters)
   - Field 49 (Currency Code - 3 digits, e.g., 840 for USD)

### Packing Messages

1. Select option **5** to pack an ISO message
2. Enter the ID of the message you want to pack
3. The system will output the hexadecimal representation

### Unpacking Packets

1. Select option **6** to unpack an ISO packet
2. Paste or type the hexadecimal string
3. The system will display the decoded ISO message fields

## Example Workflow

### 1. Create an Authorization Request

```
ID: 1
MTI: 0200
Field 2 (PAN): 1234567890123456
Field 3 (Processing Code): 000000
Field 4 (Amount): 000000012345
Field 7 (Transmission DateTime): 0311153012
Field 11 (STAN): 000001
Field 41 (Terminal ID): TERM1234
Field 49 (Currency Code): 840
```

### 2. Pack the Message

```
Enter ID to pack: 1
Packed ISO8583 Hex:
0200220000000010123456789012345600000000000000123450311153012000001TERM1234840
```

### 3. Unpack the Hex

```
Enter ISO hex packet: 0200220000000010123456789012345600000000000000123450311153012000001TERM1234840
MTI: 0200
Field 2 = 1234567890123456
Field 3 = 000000
Field 4 = 000000012345
Field 7 = 0311153012
Field 11 = 000001
Field 41 = TERM1234
Field 49 = 840
```

## Project Structure

```
cmsdemo/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java                    # Entry point and CLI interface
│           ├── model/
│           │   └── IsoMessageData.java      # Data model for ISO messages
│           ├── service/
│           │   ├── IsoCrudService.java      # CRUD operations
│           │   └── IsoParserService.java    # Pack/Unpack operations
│           └── util/
│               └── FileUtil.java           # File utilities
├── pom.xml                                  # Maven configuration
└── README.md                               # This file
```

## Dependencies

- **jPOS 2.1.9** - ISO 8583 framework for Java
- **Maven Compiler Plugin 3.11.0** - Java compilation

## Building from Source

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package into JAR
mvn package

# Install to local repository
mvn install
```

## Troubleshooting

### Common Issues

1. **"Cannot resolve symbol 'jpos'"**
   - Run `mvn clean compile` to download dependencies
   - Refresh your IDE's Maven project

2. **"JAR will be empty" warning**
   - Ensure source files are in `src/main/java/`
   - Run `mvn clean package` to rebuild

3. **Compilation errors**
   - Check Java version (requires Java 11+)
   - Verify all imports are correct

### Getting Help

- Check the Maven build output for error details
- Ensure all dependencies are properly downloaded
- Verify the project structure matches Maven conventions

## License

This project is provided as-is for educational and demonstration purposes.

## Contributing

Feel free to submit issues or enhancement requests to improve the functionality of this ISO 8583 CMS demo.
