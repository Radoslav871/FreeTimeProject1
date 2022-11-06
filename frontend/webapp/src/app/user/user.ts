export class User {

  public id?: number;
  // public token: string;
  public email: string;




  constructor(id: any, email: any) {
    this.id = id;
    this.email = email;
  }

  private deserialize(input: any): this {
    if (input.id) this.id = input.id;
    this.email = input.email;
    // if (input.token) this.token = input.token;
    return this;
  }
}
