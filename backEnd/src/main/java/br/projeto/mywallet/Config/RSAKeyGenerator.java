package br.projeto.mywallet.Config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAKeyGenerator {

    public static void main(String[] args) {
        try {
            // Gera um par de chaves RSA
            KeyPair keyPair = generateRSAKeyPair();

            // Obtém as chaves pública e privada
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

            // Exibe as chaves geradas
            System.out.println("Chave Pública: " + publicKey);
            System.out.println("Chave Privada: " + privateKey);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Erro ao gerar chaves RSA: " + e.getMessage());
        }
    }

    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        // Cria um gerador de pares de chaves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        // Define o tamanho da chave (2048 bits é recomendado para segurança)
        keyPairGenerator.initialize(2048);

        // Gera o par de chaves
        return keyPairGenerator.generateKeyPair();
    }
}
