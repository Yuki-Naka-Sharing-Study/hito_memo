//package com.example.hito_memo
//
//val appModule = module {
//    single {
//        Room.databaseBuilder(androidContext(), Database::class.java, "users").build()
//    }
//
//    single {
//        get<Database>().userDao()
//    }
//
//    single {
//        UserRepository(get())
//    }
//
//    viewModel {
//        MainViewModel(get())
//    }
//}