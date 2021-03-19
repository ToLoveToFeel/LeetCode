// Created by WXX on 2021/3/19 14:41
#include <iostream>

using namespace std;

/**
 * 执行用时：80 ms, 在所有 C++ 提交中击败了46.72%的用户
 * 内存消耗：32.1 MB, 在所有 C++ 提交中击败了97.61%的用户
 */
class ParkingSystem {
public:
    int nums[3];  // nums[0~3]分别表示大、中、小车剩余车位的数量

    ParkingSystem(int big, int medium, int small) {
        nums[0] = big, nums[1] = medium, nums[2] = small;
    }

    bool addCar(int carType) {
        carType--;
        if (nums[carType] != 0) {
            nums[carType]--;
            return true;
        }
        return false;
    }
};

int main() {

    ParkingSystem t = ParkingSystem(1, 1, 0);
    cout << t.addCar(1) << endl;  // true
    cout << t.addCar(2) << endl;  // true
    cout << t.addCar(3) << endl;  // false
    cout << t.addCar(1) << endl;  // false
}
