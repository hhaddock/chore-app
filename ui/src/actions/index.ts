export const setUser = (input: any) => {
    console.log("INPUT:  ");
    console.log(input);
    return {
      type: "AUTH_USER",
      payload: {
        user: {
            username: input.username
        }
      },
    };
};