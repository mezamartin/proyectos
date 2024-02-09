
   let users = []
    export function getUser(){
        return users.pop(0)
    }
    export function setUser(user){
        
        this.users.push(user)
    }

    export function deleteUser(){
        this.users.remove(0)
    }

