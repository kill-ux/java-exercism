import java.util.*;

class RelativeDistance {
    Map<String, List<String>> familyTree;

    RelativeDistance(Map<String, List<String>> familyTree) {
        this.familyTree = new HashMap<>();
        familyTree.forEach((parent, children) -> {
            this.familyTree.computeIfAbsent(parent, k -> new ArrayList<>()).addAll(children);
            children.forEach(child -> {
                List<String> childList = this.familyTree.computeIfAbsent(child, k -> new ArrayList<>());
                if (!childList.contains(parent)) {
                    childList.add(parent);
                }
                for (String sibling : children) {
                    if (!sibling.equals(child) && !childList.contains(sibling)) {
                        childList.add(sibling);
                    }
                }
            });
        });
    }

    int degreeOfSeparation(String personA, String personB) {
        return degreeOfSeparationHelper(personA, personB, new ArrayList<>());
    }

    private int degreeOfSeparationHelper(String personA, String personB, List<String> visited) {
        if (personA.equals(personB)) {
            return 0;
        }
        if (visited.contains(personA)) {
            return -1;
        }
        visited.add(personA);
        List<String> relatives = familyTree.get(personA);
        if (relatives == null) {
            return -1;
        }
        List<Integer> pathLengths = new ArrayList<>();
        for (String person : relatives) {
            if (person.equals(personB)) {
                pathLengths.add(1);
            } else {
                int result = degreeOfSeparationHelper(person, personB, new ArrayList<>(visited));
                if (result != -1) {
                    pathLengths.add(result + 1);
                }
            }
        }
        return pathLengths.isEmpty() ? -1 : Collections.min(pathLengths);
    }
}