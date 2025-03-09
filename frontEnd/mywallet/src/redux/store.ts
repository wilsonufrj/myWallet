import { configureStore } from '@reduxjs/toolkit'
import homeSlice from '../pages/Home/homeSlice'
import authReducer from '../pages/Home/Login/authSlice'
import carteiraReducer from '../pages/Home/Carteira/carteiraSlice'

export const store = configureStore({
  reducer: {
    home: homeSlice,
    auth: authReducer,
    carteira: carteiraReducer,
  },
})

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch