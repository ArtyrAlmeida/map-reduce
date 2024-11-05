const fs = require("fs")
const path = require("path")

async function generateFiles(alphabet = ["a","b","c"], wordsPerFile = 1000, minSize = 1, maxSize = 30, split = 10) {
    const pathDir = path.join(__dirname, "../", "src/archives")

    if(!fs.existsSync(pathDir)) {
        fs.mkdirSync(pathDir)
    }

    for(let fileSplit = 0; fileSplit < split; fileSplit++) {
        const fileDir = path.join(pathDir, `archives${fileSplit}.txt`)
        fs.writeFileSync(fileDir, "") 
        for(let fileLength = 0; fileLength < wordsPerFile; fileLength++) {
            const wordSize = Math.floor((Math.random() * maxSize) + minSize)
            let word = '';
            for (let i = 0; i < wordSize; i++) {
                const index = Math.floor((Math.random() * alphabet.length));
                const char = alphabet[index]
                word+=char;
            }
            fs.appendFileSync(fileDir, `${word} `, { encoding: "utf8" })
        }
    }
}

generateFiles(["a","b","c","d","e","z"], 1000);