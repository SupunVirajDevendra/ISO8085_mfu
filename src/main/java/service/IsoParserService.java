package service;

import model.IsoMessageData;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.ISO87APackager;

public class IsoParserService {

    public String packMessage(IsoMessageData data) throws Exception {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(new ISO87APackager());

        isoMsg.setMTI(data.getMti());

        if (data.getField2() != null && !data.getField2().isEmpty()) isoMsg.set(2, data.getField2());
        if (data.getField3() != null && !data.getField3().isEmpty()) isoMsg.set(3, data.getField3());
        if (data.getField4() != null && !data.getField4().isEmpty()) isoMsg.set(4, data.getField4());
        if (data.getField7() != null && !data.getField7().isEmpty()) isoMsg.set(7, data.getField7());
        if (data.getField11() != null && !data.getField11().isEmpty()) isoMsg.set(11, data.getField11());
        if (data.getField41() != null && !data.getField41().isEmpty()) isoMsg.set(41, data.getField41());
        if (data.getField49() != null && !data.getField49().isEmpty()) isoMsg.set(49, data.getField49());

        byte[] packed = isoMsg.pack();
        return bytesToHex(packed);
    }

    public void unpackMessage(String hexPacket) throws Exception {
        byte[] packetBytes = hexStringToByteArray(hexPacket);

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(new ISO87APackager());
        isoMsg.unpack(packetBytes);

        System.out.println("MTI: " + isoMsg.getMTI());

        for (int i = 1; i <= isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i)) {
                System.out.println("Field " + i + " = " + isoMsg.getString(i));
            }
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) (
                    (Character.digit(s.charAt(i), 16) << 4)
                            + Character.digit(s.charAt(i + 1), 16)
            );
        }
        return data;
    }
}