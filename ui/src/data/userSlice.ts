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
            console.log("ACTION RECIEVED: ");
            console.log(action.type)
            state.user.username = action.payload?.username;
            var test : string[] = action.payload.role;
            
        },
        logoutUser: (state, action) => {
            state.user.username = '';
        }
    }
});

export const { authenticateUser, logoutUser } = userSlice.actions;

export default userSlice.reducer;