package org.seekay.kv.client;

import org.seekay.kv.client.model.Pair;

import java.util.List;

public class CommandLineInterface {

    public static void main(String[] args) {
        KvClient kvClient = new KvClient("http://localhost:8090");

        String command = args[0].toUpperCase();

        if("CREATE".equals(command)) {
            Pair pair = kvClient.create(new Pair(args[1], args[2]));
            System.out.println(pair);
        }
        else if("READ".equals(command)) {
            Pair pair = kvClient.read(args[1]);
            System.out.println(pair);
        }
        else if("UPDATE".equals(command)) {
            Pair pair = kvClient.update(new Pair(args[1], args[2]));
            System.out.println(pair);
        }
        else if("DELETE".equals(command)) {
            boolean successful = kvClient.delete(args[1]);
            System.out.println("Was successful? : " + successful);
        }
        else if("SEARCH".equals(command)) {
            List<Pair> pairs = kvClient.search(args[1]);
            System.out.println(pairs);
        }
        else {
            throw new IllegalArgumentException("No matching command found for args : " + args);
        }
    }
}
