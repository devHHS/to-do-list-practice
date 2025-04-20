package com.devhhs.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;     // dueDate 사용을 위한 import
import java.time.LocalDateTime; // createdAt 사용을 위한 import
import java.util.Objects;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private boolean completed;

    private LocalDate dueDate;     // 할 일의 마감일 (년, 월, 일)

    // 생성일을 저장할 필드 추가 (날짜와 시간 모두 저장)
    private LocalDateTime createdAt; // 할 일의 생성일시 (년, 월, 일, 시, 분, 초)


    // --- 생성자 ---
    // JPA Entity는 기본 생성자가 필요합니다.
    // JPA가 데이터베이스에서 데이터를 읽어와 객체를 생성할 때 사용합니다.
    public TodoItem() {
    }

    // 할 일 내용만 받아 객체를 생성하는 생성자 (마감일 없음, 생성일시는 현재 시간으로 자동 설정)
    public TodoItem(String description) {
        this.description = description;
        this.completed = false;
        this.dueDate = null;
        this.createdAt = LocalDateTime.now();
    }

    // 할 일 내용과 마감일을 받아 객체를 생성하는 생성자 (생성일시는 현재 시간으로 자동 설정)
    public TodoItem(String description, LocalDate dueDate) {
        this.description = description;
        this.completed = false;
        this.dueDate = dueDate;
        this.createdAt = LocalDateTime.now();
    }


    // --- Getter와 Setter ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed; // 인스턴스 변수에 직접 값을 할당
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // createdAt 필드의 값을 가져오는 메서드 추가
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    // --- 기타 유용한 메서드 ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        // equals 비교 시 id만 비교
        return Objects.equals(id, todoItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Debugging Message
    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", dueDate=" + dueDate +
                ", createdAt=" + createdAt +
                '}';
    }
}