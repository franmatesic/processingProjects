color COLOR[] = {#e6194b, #3cb44b, #ffe119, #f58231, #911eb4, #f032e6, #bfef45, #fabebe, 
  #e6beff, #469990, #fffac8, #800000, #aaffc3, #ffd8b1};

int[] toPartitions(int value, int partitions, int minValue) {
  int result[] = new int[partitions];
  int part[] = new int[partitions + 1];
  part[0] = 0;
  part[partitions] = value;
  int min = value + 1;
  while (min < minValue || min > value) {
    for (int i = 1; i < partitions; i++) part[i] = int(random(value));
    part = sort(part);

    min = value + 1;
    result = new int[partitions];
    for (int i = 0; i < partitions; i++) {
      result[i] = part[i + 1] - part[i];
      if (result[i] < min) min = result[i];
    }
  }
  return result;
}

int arrSum(int arr[]) {
  int sum = 0;
  for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum;
}
