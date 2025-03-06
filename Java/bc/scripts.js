// 블록 클래스
class Block {
    constructor(prevHash, data) {
        this.prevHash = prevHash; // 이전 블록 해시
        this.data = data;         // 블록 데이터
        this.hash = this.calculateHash(); // 현재 블록 해시
    }

    // SHA-256 해시 계산
    async calculateHash() {
        const encoder = new TextEncoder();
        const dataToHash = encoder.encode(this.prevHash + this.data);
        const hashBuffer = await crypto.subtle.digest('SHA-256', dataToHash);
        const hashArray = Array.from(new Uint8Array(hashBuffer));
        return hashArray.map(byte => byte.toString(16).padStart(2, '0')).join('');
    }
}

// 블록체인 초기화
const blockchain = [new Block("0", "Genesis Block")]; // 제네시스 블록 생성

// 블록체인 UI 업데이트 함수
async function updateBlockchain() {
    const blockchainDiv = document.getElementById("blockchain");
    blockchainDiv.innerHTML = ''; // 기존 블록 초기화

    for (const block of blockchain) {
        const blockDiv = document.createElement("div");
        blockDiv.className = "block";

        const prevHashDiv = document.createElement("p");
        prevHashDiv.className = "prev-hash";
        prevHashDiv.textContent = `Previous Hash: ${block.prevHash}`;

        const dataDiv = document.createElement("p");
        dataDiv.className = "data";
        dataDiv.textContent = `Data: ${block.data}`;

        const hashDiv = document.createElement("p");
        hashDiv.className = "hash";
        hashDiv.textContent = `Hash: ${await block.hash}`;

        blockDiv.appendChild(prevHashDiv);
        blockDiv.appendChild(dataDiv);
        blockDiv.appendChild(hashDiv);

        blockchainDiv.appendChild(blockDiv);
    }
}

// 블록 추가 함수
async function addBlock() {
    const data = prompt("Enter data for the new block:");
    if (data) {
        const prevHash = await blockchain[blockchain.length - 1].hash;
        const newBlock = new Block(prevHash, data);
        blockchain.push(newBlock);
        await updateBlockchain();
    }
}

// 초기 블록체인 UI 업데이트
updateBlockchain();
