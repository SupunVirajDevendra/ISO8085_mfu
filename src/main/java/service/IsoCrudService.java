package service;

import model.IsoMessageData;
import java.util.ArrayList;
import java.util.List;

public class IsoCrudService {
    private final List<IsoMessageData> messages = new ArrayList<>();

    public void create(IsoMessageData data) {
        messages.add(data);
    }

    public List<IsoMessageData> getAll() {
        return messages;
    }

    public IsoMessageData getById(int id) {
        for (IsoMessageData msg : messages) {
            if (msg.getId() == id) {
                return msg;
            }
        }
        return null;
    }

    public boolean update(int id, IsoMessageData updatedData) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId() == id) {
                messages.set(i, updatedData);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return messages.removeIf(msg -> msg.getId() == id);
    }
}
