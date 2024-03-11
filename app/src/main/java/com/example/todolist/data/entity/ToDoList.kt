package com.example.todolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName="todolist")
data class ToDoList(@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "not_id") @NotNull var not_id :Int,
                    @ColumnInfo(name="not_ad")@NotNull var  not_ad :String ,
                    @ColumnInfo(name="aciklama")@NotNull var aciklama : String ) : Serializable{
}