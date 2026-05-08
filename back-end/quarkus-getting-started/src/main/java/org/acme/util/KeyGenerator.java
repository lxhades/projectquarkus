package org.acme.util;

import java.io.FileWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);

        KeyPair pair = keyGen.generateKeyPair();

        writePrivateKey(pair.getPrivate());
        writePublicKey(pair.getPublic());

        System.out.println("JWT keys generated!");
    }

    private static void writePrivateKey(PrivateKey privateKey) throws Exception {

        String key = Base64.getEncoder()
                .encodeToString(privateKey.getEncoded());

        FileWriter writer = new FileWriter("src/main/resources/privateKey.pem");

        writer.write("-----BEGIN PRIVATE KEY-----\n");
        writer.write(key);
        writer.write("\n-----END PRIVATE KEY-----");

        writer.close();
    }

    private static void writePublicKey(PublicKey publicKey) throws Exception {

        String key = Base64.getEncoder()
                .encodeToString(publicKey.getEncoded());

        FileWriter writer = new FileWriter("src/main/resources/publicKey.pem");

        writer.write("-----BEGIN PUBLIC KEY-----\n");
        writer.write(key);
        writer.write("\n-----END PUBLIC KEY-----");

        writer.close();
    }
}