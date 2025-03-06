import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;

public class main {

    // 블록 클래스
    static class Block {
        String prevHash; // 이전 블록의 해시
        String data;     // 블록에 담을 데이터
        String hash;     // 현재 블록의 해시

        // 생성자: 데이터와 이전 블록의 해시를 받아서 해시를 계산
        Block(String prevHash, String data) {
            this.prevHash = prevHash;
            this.data = data;
            this.hash = calculateHash();  // 해시 계산
        }

        // 해시 계산하는 함수
        String calculateHash() {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                String input = prevHash + data; // 이전 해시와 데이터 합침
                byte[] hashBytes = digest.digest(input.getBytes()); // 해시 계산

                // 바이트 배열을 16진수로 변환
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    hexString.append(String.format("%02x", b));
                }
                return hexString.toString(); // 해시 반환
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("SHA-256 Algorithm not found", e);
            }
        }
    }

    // 블록체인 클래스
    static class Blockchain {
        Stack<Block> chain;  // 블록체인을 스택으로 저장

        // 생성자: 첫 번째 블록인 제네시스 블록을 추가
        Blockchain() {
            chain = new Stack<>();
            chain.push(new Block("0", "Genesis Block"));  // 첫 번째 블록
        }

        // 블록을 블록체인에 추가하는 함수
        void addBlock(String data) {
            String prevHash = chain.peek().hash;  // 마지막 블록의 해시
            Block newBlock = new Block(prevHash, data);  // 새 블록 생성
            chain.push(newBlock);  // 블록 추가
        }

        // 블록체인의 모든 블록을 출력하는 함수
        void show() {
            for (Block block : chain) {
                System.out.println("Data: " + block.data);
                System.out.println("Hash: " + block.hash);
                System.out.println("Previous Hash: " + block.prevHash);
                System.out.println("----------------------");
            }
        }
    }

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();  // 새로운 블록체인 생성

        // 블록 추가
        blockchain.addBlock("First Block after Genesis");
        blockchain.addBlock("Second Block");
        blockchain.addBlock("Third Block");

        // 블록체인 출력
        blockchain.show();
    }
}
