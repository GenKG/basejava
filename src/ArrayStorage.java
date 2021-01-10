import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int x = 0; x < storage.length; x++){
            storage[x] = null;
        }
    }

    void save(Resume r) {
        for (int x = 0; x <storage.length;x++){
            if (storage[x] == null) {
                storage[x] = r;
                break;
            }
            else continue;
        }
    }

    Resume get(String uuid) {
        Resume value = new Resume();
        try {
            for (Resume resume : storage) {
                if (resume.uuid.equals(uuid)) {
                    value = resume;
                    break;
                }
            }
        } catch (NullPointerException e){
            System.out.println("нет такого uuid");
        }
        return value;
    }

    void delete(String uuid) {
        try {
            for (Resume element : storage) {
                for (int x = 0; x < storage.length; x++) {
                    if (storage[x].uuid != null) {
                        if (storage[x].uuid.equals(uuid)) {
                            storage[x] = null;
                            for (int y = x + 1; y < storage.length - 1; y++) {
                                if (storage[y] != null) {
                                    storage[x] = storage[y];
                                    storage[y] = null;
                                } else break;
                            }
                        }
                    } else break;
                }
            }
        } catch (NullPointerException e){
            System.out.println("нет такого uuid");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return storage.length;
    }
}
