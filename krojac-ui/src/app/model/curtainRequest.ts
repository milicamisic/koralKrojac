export class CurtainRequest {
  height!: number;       // window height
  width!: number;        // window width
  pleatFactor!: number;  // 1.5, 2, etc.
  hangingType!: string;  // HOOKS, RINGS, CHANNEL

  constructor(init?: Partial<CurtainRequest>) {
    Object.assign(this, init);
  }
}
