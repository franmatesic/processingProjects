import peasy.*;

PeasyCam cam;

//Part 3  10:11

int dim = 3;
Cubie[] cube;

String[] allMoves = {"f", "b", "u", "d", "l", "r"};
String sequence = "";
int step = 2;

int shuffleCounter = 0, solveCounter = 1;
boolean shuffle = false, solve = false;

Move move;

void setup() {
  size(600, 600, P3D);

  cam = new PeasyCam(this, 400);

  cube = new Cubie[dim* dim * dim];

  int index = 0;
  int min = -dim/2;
  int max = dim/2;
  for (int x = min; x <= max; x++) {
    for (int y = min; y <= max; y++) {
      for (int z =  min; z <= max; z++) {

        PMatrix3D matrix = new PMatrix3D();
        matrix.translate(x, y, z);
        cube[index] = new Cubie(matrix, x, y, z);
        index++;
      }
    }
  }

  move = new Move(0, 0, 1, 1);
  move.start();
}

void shuffleCube(int moves) {
  for (int i = 0; i < moves; i++) {
    int r = int(random(allMoves.length));
    if (random(1) < 0.5) {
      sequence += allMoves[r];
    } else {
      sequence += allMoves[r].toUpperCase();
    }
  }
}

String flipCase(char c) {
  String s = "" + c;
  if (s.equals(s.toLowerCase())) {
    return s.toUpperCase();
  } else {
    return s.toLowerCase();
  }
}


void draw() {
  background(51);
  rotateX(-0.5);
  rotateY(0.5);

  move.update();

  if (shuffle && shuffleCounter < sequence.length() && frameCount % step == 0) {
    char move = sequence.charAt(shuffleCounter);
    applyMove(move);

    shuffleCounter++;
    print(move);
  }

  if (solve && solveCounter >= 0 && frameCount % step == 0) {
    char move = flipCase(sequence.charAt(solveCounter)).charAt(0);
    applyMove(move);
    sequence = sequence.substring(0, solveCounter);

    solveCounter--;
    print(move);
  }

  scale(50);
  for (int i = 0; i < cube.length; i++) {
    push();
    if (abs(cube[i].z) > 0 && cube[i].z == move.z) {
      rotateZ(move.angle);
    }
    cube[i].show();
    pop();
  }
}

void keyPressed() {
  if (key == ' ') {
    shuffleCube(5);
    if (solve)
      shuffleCounter = 0;
    shuffle = true;
    solve = false;
    print("\n");
  }
  if (key == 's' && sequence.length() > 0) {
    solveCounter = sequence.length() - 1;
    solve = true;
    shuffle = false;
    print("\n");
  } else if (sequence.length() == 0) {
    println("Not shuffled");
  }

  applyMove(key);
}

void applyMove(char move) {
  switch(move) {
  case 'f':
    turnZ(1, 1);
    break;
  case 'F':
    turnZ(1, -1);
    break;
  case 'b':
    turnZ(-1, -1);
    break;
  case 'B':
    turnZ(-1, 1);
    break;
  case 'u':
    turnY(-1, 1);
    break;
  case 'U':
    turnY(-1, -1);
    break;
  case 'd':
    turnY(1, -1);
    break;
  case 'D':
    turnY(1, 1);
    break;
  case 'l':
    turnX(-1, -1);
    break;
  case 'L':
    turnX(-1, 1);
    break;
  case 'r':
    turnX(1, 1);
    break;
  case 'R':
    turnX(1, -1);
    break;
  }
}

void turnZ(int index, int dir) {
  for (int i = 0; i < cube.length; i++) {
    Cubie qb = cube[i];
    if (qb.z == index) {
      PMatrix2D matrix = new PMatrix2D();
      matrix.rotate(HALF_PI * dir);
      matrix.translate(qb.x, qb.y);
      qb.update(round(matrix.m02), round(matrix.m12), round(qb.z));
      qb.turnFacesZ(dir);
    }
  }
}
void turnY(int index, int dir) {
  for (int i = 0; i < cube.length; i++) {
    Cubie qb = cube[i];
    if (qb.y == index) {
      PMatrix2D matrix = new PMatrix2D();
      matrix.rotate(HALF_PI * dir);
      matrix.translate(qb.x, qb.z);
      qb.update(round(matrix.m02), round(qb.y), round(matrix.m12));
      qb.turnFacesY(dir);
    }
  }
}
void turnX(int index, int dir) {
  for (int i = 0; i < cube.length; i++) {
    Cubie qb = cube[i];
    if (qb.x == index) {
      PMatrix2D matrix = new PMatrix2D();
      matrix.rotate(HALF_PI * dir);
      matrix.translate(qb.y, qb.z);
      qb.update(round(qb.x), round(matrix.m02), round(matrix.m12));
      qb.turnFacesX(dir);
    }
  }
}
