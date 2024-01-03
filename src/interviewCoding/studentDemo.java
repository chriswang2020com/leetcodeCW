package org.example.interviewCoding;

import java.util.*;

class Student implements Comparable<Student> {
    int idx;
    int score;
    int quality;
    public Student(int idx, int score, int quality){
        this.idx = idx;
        this.score = score;
        this.quality = quality;
    }

    @Override
    public int compareTo(Student other){
        if (this.score != other.score){
            return other.score -this.score;
        }
        else{
            return other.quality - this.quality;
        }
    }
}

public class studentDemo {
    public static void main(String[] args) {
        int[] scores = {98, 98, 97, 90, 87, 82, 87};
        int[] qualityScores = {8, 9, 8, 1, 2, 3, 4}; // 假设最后一个学生的素质分为 4
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < scores.length; i++){
            students.add(new Student(i, scores[i], qualityScores[i]));
        }
        Collections.sort(students);
        for (Student student: students){
            System.out.println("Index: " + student.idx);
        }

    }
}
