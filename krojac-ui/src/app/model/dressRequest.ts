export class DressRequest {
  type!: string;        // A-line, Circle, Bodycon, Shift
  bust!: number;        // chest circumference
  hips!: number;        // hip circumference
  shoulder!: number;    // shoulder width
  height!: number;      // user height
  length!: number;      // dress length
  wrap!: boolean;       // wrap or not
  sleeveType!: string;  // NONE, SHORT, LONG

  constructor(init?: Partial<DressRequest>) {
    Object.assign(this, init);
  }
}
