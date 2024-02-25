import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    user: {
        username: '',
        email: '',
        roles: []
    }
};

const userSlice = createSlice({
    name: "user",
    initialState: initialState,
    reducers: {
        authenticateUser: (state, action) => {
            state.user.username = action.payload?.username;
            state.user.email = action.payload?.email;
            state.user.roles = action.payload?.roles;
        },
        logoutUser: (state, action) => {
            state.user.username = '';
        }
    }
});

export const { authenticateUser, logoutUser } = userSlice.actions;

export default userSlice.reducer;