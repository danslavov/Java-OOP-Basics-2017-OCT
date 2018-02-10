package entities;

import java.util.*;

public class Organism {

    private String name;
    private Map<String, Cluster> clusters;
    private Queue<String> activationOrder;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
        this.activationOrder = new ArrayDeque<>();
    }

    public String getName() {
        return this.name;
    }

    public void addCluster(Cluster cluster) {
        String clusterId = cluster.getId();
        if (!this.clusters.containsKey(clusterId)) {
            this.clusters.put(clusterId, cluster);
            this.activationOrder.offer(clusterId);
        }
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }

    private int getCellCount() {
        int result = 0;
        for (Cluster cluster : clusters.values()) {
            result += cluster.getCells().size();
        }
        return result;
    }

    public Cluster getClusterToActivate() {
        String clusterId = this.activationOrder.poll();
        this.activationOrder.offer(clusterId);
        return this.getClusters().get(clusterId);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(
                "Organism - %s\n--Clusters: %d\n--Cells: %d\n",
                this.getName(), this.getClusters().size(), this.getCellCount()));

        for (int i = 0; i < clusters.size(); i++) {
            Cluster cluster = clusters.get(activationOrder.poll());
            result.append(cluster);
        }

        return result.toString();
    }
}
