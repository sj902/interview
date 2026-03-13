package com.sj902;

public class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char dir = 'N';
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)){
                case 'G':
                    switch (dir){
                        case 'N': y = y+1;
                            break;
                        case 'E': x = x-1;
                            break;
                        case 'W': x = x+1;
                            break;
                        case 'S': y = y-1;
                            break;
                    }
                case 'L':
                    switch (dir){
                        case 'N': dir = 'E';
                            break;
                        case 'E': dir = 'S';
                            break;
                        case 'W': dir = 'N';
                            break;
                        case 'S': dir = 'W';
                            break;
                    }
                case 'R':
                    switch (dir){
                        case 'N': dir = 'W';
                            break;
                        case 'E': dir = 'N';
                            break;
                        case 'W': dir = 'S';
                            break;
                        case 'S': dir = 'E';
                            break;
                    }
            }
        }
        if((x ==0 && y == 0) || dir!='N') return true;
        return false;
    }
}
