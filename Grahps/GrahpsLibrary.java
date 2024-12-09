package library;

import java.util.*;

class GraphsLibrary {
    private final Map<String, Set<String>> relations;

    public GraphsLibrary() {
        this.relations = new HashMap<>();
    }

    public void addRelation(String user, String book) {
        relations.putIfAbsent(user, new HashSet<>());
        relations.get(user).add(book);
    }

    public void removeRelation(String user, String book) {
        if (relations.containsKey(user)) {
            relations.get(user).remove(book);
            if (relations.get(user).isEmpty()) {
                relations.remove(user); 
            }
        }
    }

    public void listRelations() {
        relations.forEach((user, books) -> {
            System.out.println(user + " -> " + books);
        });
    }
}
