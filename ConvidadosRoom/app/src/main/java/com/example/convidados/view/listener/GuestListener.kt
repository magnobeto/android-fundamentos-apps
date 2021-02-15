package com.example.convidados.view.listener

import com.example.convidados.service.model.GuestModel

interface GuestListener {
    fun onClick(id: Int)
    fun onDelete(guest: GuestModel)
}