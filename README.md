# 🎮 Tetris in Java

A simple and fun **Tetris game** built using **Java** and developed in **Eclipse IDE**. This project captures the core mechanics of the classic game with intuitive controls and smooth block movement.

---

## 🗂️ Project Structure


Tetris/ | Main project folder <br />
├── main/ <-- Core game logic & execution <br />
│   ├── Main.java <-- Entry point of the program <br />
│   ├── GamePanel.java <-- Renders the game & runs logic <br />
│   ├── KeyHandler.java <-- Handles keyboard inputs<br />
│   └── PlayManager.java <-- Manages the game's state & progression<br />
└── mino/ <-- Tetromino pieces<br />
├── Block.java <-- Represents a single square block<br />
├── Mino.java <-- Base class for all tetromino shapes<br />
├── MinoBar.java <-- I-shaped piece<br />
├── MinoL1.java <-- L-shaped piece<br />
├── MinoL2.java <-- Reverse L-shaped piece<br />
├── MinoT.java <-- T-shaped piece<br />
├── MinoZ1.java <-- Z-shaped piece<br />
├── MinoZ2.java <-- Reverse Z-shaped piece<br />
└── NMino.java <-- Custom or experimental shape<br />

---

## 🧩 Game Features

- 🔄 Block rotation
- ⬅️➡️ Directional movement
- ⬇️ Fast drop
- 🚫 Game over detection
- ✅ Line clear logic
- 🎨 Simple and clean Java Swing GUI

---

## 🕹️ Controls

| Key          | Action              |
|--------------|---------------------|
| ⬅️ Left Arrow | Move block left     |
| ➡️ Right Arrow| Move block right    |
| ⬇️ Down Arrow | Accelerate drop     |
| ⬆️ Up Arrow   | Rotate the block    |

---

## ⚙️ How to Run

1. Clone or download the project.
2. Open it in **Eclipse IDE**.
3. Make sure JDK is installed and configured.
4. Navigate to `Main.java` inside the `main/` package.
5. Run `Main.java` and enjoy the game!

---

## 💻 Technologies Used

- Java (JDK 8+)
- Eclipse IDE
- Java AWT & Swing for UI

---

## 📸 Preview

![image](https://github.com/user-attachments/assets/1d83bdc0-3d9e-4ada-b369-b8b8e31bc519)
![image](https://github.com/user-attachments/assets/83b430ec-445c-484a-8cc9-daa0970dcb15)
![image](https://github.com/user-attachments/assets/58f59346-0063-4bbe-b715-83d445f5b1a9)
![image](https://github.com/user-attachments/assets/20dbb014-e389-4cd0-95a1-e9147c06ea76)


---

## 👨‍💻 Author

Made by **[Hamza]**

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

> 🚀 Have fun playing and customizing the game! Contributions, forks, and stars are always welcome :)
